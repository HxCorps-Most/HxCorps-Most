# HxCorps-Most

#### 안드로이드 환경에서 html document를 파싱해서 각각의 텍스트 값에 속성을 부여해보는 작업을 해봅시다!
<br/><br/>
<img src="https://github.com/HxCorps-Most/HxCorps-Most/blob/android-parse/gisa.png" width=700px height=350px/>
<br/><br/><br/><br/>
#### 주어진 안드로이드 프로젝트는 상위 기사가 속해있는 html document의 BODY 태그를 추출한 것입니다.
<br/><br/><br/><br/>
<img src="https://github.com/HxCorps-Most/HxCorps-Most/blob/android-parse/working-screen-android.jpg" width=200px height=400px/>
<br/><br/>
#### 상위 기사를 보면 글씨 색깔도 다르고, bold체 등 여타 텍스트에 부여될 수 있는 속성들이 충분히 활용된 것을 볼 수 있는데,
#### 반면, 안드로이드 환경에서 파싱된 document의 내용은 굉장히 단조롭죠?

## 오늘의 실습내용

* 안드로이드 프로젝트를 clone 하여 시동해본다.
* 태그의 속성을 반영해보는 방법을 찾는다 
가령, 
<code>
  <b> [한 끗 리빙]한 달도 거뜬한 귤 보관법 </b>
</code> 는 bold 속성의 태그가 적용되어 있지만 안드로이드 파싱 결과에서는 그렇지 않죠?
* 기사의 텍스트만을 추출하여, 글자 색을 바꾸고 글자체(일반체에서 볼드체로)를 바꿔본다.
