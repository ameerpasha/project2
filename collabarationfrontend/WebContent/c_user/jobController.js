/**
 * Job Controller
 */
myapp.controller('jobController',function(jobService,$scope,$location){
	
	
	function getAllJobs(){
		jobService.getAllJobs().then(function(response){
			$scope.jobs=response.data;
		},function(response){
			$location.path('/login')
		})
	}
	
	$scope.save=function(){
		jobService.save($scope.job).then(function(response){
			$location.path('/getalljobs')
		},function(response){
			console.log(response.status)
			if(response.status==401){
				$scope.error=response.data
				alert("Access Denied. Only Admin can add Jobs.")
				$location.path('/login')
			}
			if(response.status==500){
				$scope.error=response.data
				$location.path('/saveJob')
			}
			$location.path('/home')
		})
	}
getAllJobs()	
	
})