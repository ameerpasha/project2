/**
 * 
 */
'use strict';

app.controller('HomeController',['$scope','UserService','$rootScope',function($scope,UserService,$rootScope){
	console.log('HomeController.....')
	
	var self=this;
	
	self.user={
			
			user_id : '',
			user_name: '',
			password:'',
			email: '',
			cpassword:'',
			role: '',
			errormessage: ''
	};
	self.users =[];
	
	self.getCurrentUser =function(){
		console.log("Loading current user if already logged in")
		console.log("current user!:" +$rootsScope.currentUser)
		if(!rootScope.currentUser){
			console.log("User not logged in")
			$rootScope.currentUser="";
		}
		return $rootScope.currentUser;
	}
	
	self.getCurrentUser;	
	
}])