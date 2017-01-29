# full-stack-developer

For a full stack developer

## Spring Thymeleaf
	git clone https://github.com/AllenAi007/full-stack-developer.git
	cd full-stack-developer/spring-thymeleaf
	mvn spring-boot:run
  

## Layout of Thymeleaf
    Using th:replace is not that convenient to build up layout, so instead of it, using Thymeleaf Layout Dialect(http://stackoverflow.com/questions/22212512/extend-a-view-with-thymeleaf)
    In header, it looks fine, however for body, it cant append the javascript so that I write new fragment for javascript <th:block layout:fragment="javascripts"></th:block>