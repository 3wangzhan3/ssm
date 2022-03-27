app.service("breadService",function ($http) {

    this.findByParentId=function (id) {
        return  $http.get("/ssm/getBreadData?id="+id);
    }
})