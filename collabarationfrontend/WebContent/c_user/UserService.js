/**
 * 
 */
myapp.factory('UserService',function($http){
	var userService={};
	var BASE_URL="http://localhost:8092/collabarationbackend"
		
		userService.registeruser=function(user){
		
		return $http.post(BASE_URL+"/registeruser",user)
	}
	
userService.isValidUser=function(user){
		
		return $http.post(BASE_URL+"/login",user)
	}
userService.logout=function(){
	
	return $http.get(BASE_URL+"/logout")
}

userService.updateUser=function(user){
	
	return $http.put(BASE_URL+"/updateuser",user)
}

return userService;
})