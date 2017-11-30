/**
 * BlogController
 */
myapp.controller('blogController',function(blogService,$scope,$location){
	$scope.createBlog=function(){
		blogService.createBlog($scope.blog).then(function(response){
			console.log(response.status)
			alert('Blog added successfully.. It is waiting for approval')
			$location.path('/blog')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			$location.path('/blog')
		})
	}
})/**
 * 
 */