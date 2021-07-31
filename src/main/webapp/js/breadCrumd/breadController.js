app.controller("myController", function($scope,breadService) {

    $scope.list={}
    $scope.entity_1={}
    $scope.entity_2={}

    $scope.grade=1;//默认为1级
    $scope.setGrade = function (value) {
        $scope.grade = value;
    }
    $scope.findByParentId= function (id) {
        breadService.findByParentId(id).success(function (response) {
            if ($scope.grade===1){
                $scope.list=response
            }else if ($scope.grade===2){
                $scope.entity_1 =response
            }else{
                $scope.entity_2 =response
            }
        })
    }
})