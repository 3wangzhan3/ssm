app.service("breadService",function ($http) {

    this.findByParentId=function (id) {
        return  $http.get("/getBreadData?id="+id);
    }
})