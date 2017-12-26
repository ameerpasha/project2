/**
 * 
 */
myapp.controller('FriendController',['$scope','FriendService','$location','$rootScope','$http',
	
	                  function($scope,FriendService,$location,$rootScope,$http){
	console.log("FriendController..")
	 var selfs=this;
	selfs.friend={
			id: '',
			name:'',
			friendname:'',
			request_status:'',
			isOnline:'',
			friend_id:'',
			user_id:'',
			errorCode:'',
			errorMessage:'',
			
	};
	selfs.friends=[];
	
	selfs.user={
			user_id:'',
	         user_name:'',
	         password:'',
	         firstname:'',
	         lastname:'',
	         contact:'',
	          email:'',
	          role:'',
	          isOnline:'',
	         errorCode:'',
	         errorMessage:'',
	};
	selfs.users=[];
	
	selfs.sendFriendRequest=sendFriendRequest
	
	function sendFriendRequest(friendID)
	{
		console.log("sendFriendRequest:" + friendID)
		friendService.sendFriendRequest(friendID)
		.then(
		function(d){
			selfs.friend=d;
			alert("Friend Request Sent")
		},function(errResponse){
			console.error('Error while sending Friend requests');
		}		
		);
	};
	
	selfs.getMyFriends=function(){
		console.log("getting My Friends")
		FriendService.getMyFriends()
		.then(
			function(d){
				selfs.friends=d;
				console.log("Got the friends list")
			},function(errResponse){
				console.error('Error while sending Friend requests');
			}	
				
				);
	};
	selfs.updateFriendReques=function(friend,id){
		FriendsService.updateFriendRequest(friend,id)
		.then(
			selfs.fetchAllFriends,
			function(errResponse){
				console.error('Error while updating friend');
			}
				
		);
		};
		
		selfs.deleteFriend=function(id){
			FriendService.deleteFriend(id)
			.then(
					selfs.fetchAllFriends,
					function(errResponse){
						console.error('Error while deleting friend');
					}
						
					
			);
		};
		
		selfs.fetchAllUsers=function(){
			FrinedService.fetchAllUsers().then(function(d){
				console.log('caling users from friend conroller')
				selfs.users=d;
			},
			function(errResponse){
				console.error('error while fetching users');
			
				
			});
			
		};
		selfs.fetchAllUsers();
		selfs.getMyFriends();
}
	
	])
