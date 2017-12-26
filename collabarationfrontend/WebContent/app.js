 var myapp=angular.module("myapp",['ngRoute','ngCookies']);

myapp.config(function($routeProvider){
	$routeProvider
	
	
	
	.when('/home',{
		templateUrl:'c_home/home.html',
		
		
	})
	
	.when('/login',{
		templateUrl:'c_user/login.html',
		controller:'userController'
		
	})
	
	.when('/register',{
		templateUrl:'c_user/register.html',
		controller:'userController'
		
	})
	
	.when('/updateprofile',{
		templateUrl:'c_user/updateprofile.html',
		controller:'userController'
		
	})
	
	.when('/blog',{
		templateUrl:'c_user/blog.html',
		controller:'blogController'
		
	})
	
	.when('/job',{
		templateUrl:'c_user/job.html',
		controller:'jobController'
		
	})
	
	.when('/getalljobs',{
		templateUrl:'c_user/jobtitles.html',
		controller:'jobController'
	})
	
	.when('/addfriend',{
		templateUrl:'c_user/list_friend.html',
		controller:'FriendController'
		
	})
	.when('/job',{
		templateUrl:'c_user/job.html',
		controller:'jobController'
		
	})
	
	.when('/chat_forum',{
		templateUrl:'c_chat_forum/chat_forum.html',
		controller:'ChatForumController'
		
	})
	
		

	
	.otherwise({
		templeteUrl:'c_home/home.html'});
	
	
})
myapp.run(function($rootScope,$cookieStore){
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get("currentUser")
})