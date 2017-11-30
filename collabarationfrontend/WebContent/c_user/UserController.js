/**
 * 
 */


myapp.controller('userController',function(UserService,$scope,$rootScope,$location,$cookieStore){
	
	$scope.user={}
	$scope.registeruser=function(){
		UserService.registeruser($scope.user).then(
		function(response){
			$scope.message="registered successfully..pls. login"
				$location.path('/login')
			
		},function(response){
			console.log(response.status)
			console.log(response.data)
			$scope.error=response.data
			$location.path('/register')
		})
	}
	$scope.isValidUser=function(){
		UserService.isValidUser($scope.user).then(function(response){
			console.log(response.data) 
			$rootScope.currentUser=response.data
			$cookieStore.put("currentUser",response.data)
			$location.path('/home')
		}
		,function(response){
			$scope.error=response.data
			console.log(response.data)
			$location.path('/login')
		})
	}
	$rootScope.logout=function(){
		UserService.logout().then(function(response){
			
			$rootScope.logoutSuccess="logged out successfully.."
				delete $rootScope.currentUser
				
			$cookieStore.remove("currentUser")
			$location.path('/login')
		}
		,function(response){
			$scope.error=response.data
			$location.path('/login')
		})
	}
	 $scope.updateUser=function(){
		 UserService.updateUser($rootScope.currentUser).then(function(response){
			 alert("updated successfully")
         $location.path('/home')
		 },function(response){
			 console.log(response.data)
			 
			 if(response.status==401)
				 $location.path('/login')
				 $location.path('/updateprofile')
		 })
		 
		 
	 }
})
		
	
		
