# AppEightMusicList
## fragment Navigation
1. navigation 만들기
- res > navigation 폴더 만들기
- New > Android Resource File > resouce type : navigation > main_nav.xml > ok (gradle implementation navigation 자동 추가됨)

2. 액티비티 위 NavHostFragment 만들기
- activity xml > Design Palette > container > NavHostFragment > main_nav.xml 선택

AppEightMusicList에서 [activity xml](https://github.com/okrecords/AppEightMusicList/blob/master/app/src/main/res/layout/activity_main.xml)

3. fragment 만들고 navigation 연결
- main_nav.xml > Design 에서 add a destination
- fragment xml 연결

AppEightMusicList에서 [Navigation](https://github.com/okrecords/AppEightMusicList/blob/master/app/src/main/res/navigation/main_nav.xml)

4. fragment 버튼 이동 만들어 NavController 연결
- fragment xml에 버튼 만들기 > Fragment.kt에 findNavController
```
button.setOnClickListener {     
  it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
}
```
AppEightMusicList에서 [NavController](https://github.com/okrecords/AppEightMusicList/blob/890b116e28a646176d75e5c569e54c9c0629d886/app/src/main/java/com/okre/appeightmusiclist/FirstFragment.kt#L42)
<br/><br/><br/>

## RecyclerView
- 생성한 뷰를 재활용하는 뷰홀더 패턴 사용(항목이 갱신될 때마다 매번 아이템 뷰를 새로 구성해야 하는 ListView 단점 개선)

구현 순서
1. 레이아웃에 RecyclerView 추가
```
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
LayoutManager xml에서 지정하려면 이곳에 추가
- LinearLayoutManager
```
<androidx.recyclerview.widget.RecyclerView
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        android:orientation="vertical" />
```
- GridLayoutManager
```
<androidx.recyclerview.widget.RecyclerView
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:spanCount="2"
        android:orientation="vertical" />
```
androidStudyMusicList에서 [fragment_first.xml](https://github.com/okrecords/AppEightMusicList/blob/890b116e28a646176d75e5c569e54c9c0629d886/app/src/main/res/layout/fragment_first.xml#L23)
<br/><br/>

2. 아이템 뷰 레이아웃 추가  
androidStudyMusicList에서 [rv_item.xml](https://github.com/okrecords/AppEightMusicList/blob/master/app/src/main/res/layout/rv_item.xml)
<br/><br/>

3. 데이터를 data class로 정의
```
data class Item(
    var item1 : Int? = null,
    var item2 : String? = ""
)
```
<br/><br/>

4. 어댑터 클래스 생성   
- 어댑터 클래스 생성 후 데이터 받기
```
class RVAdapter : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    private val itemList : MutableList<Item> = arrayListOf()
```
Carrot에서 [RVAdapter.kt](https://github.com/okrecords/Carrot/blob/2323f748c7a2bb7abe4591f92fd3db7f116ce785/app/src/main/java/com/okre/carrot/RVAdapter.kt#L9)

- 어댑터 클래스 생성과 동시에 데이터 받기
```
class RVAdapter (val itemList : MutableList<Item>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
```
androidStudyMusicList에서 [RVAdapter.kt](https://github.com/okrecords/AppEightMusicList/blob/master/app/src/main/java/com/okre/appeightmusiclist/RVAdapter.kt)
<br/><br/>

5. 어댑터 연결 
- 어댑터 클래스 생성 후 데이터 받는 경우
```
private val rvAdapter = RVAdapter()

val mainRv = binding.mainRv
mainRv.adapter = rvAdapter
```
Carrot에서 [어댑터 연결](https://github.com/okrecords/Carrot/blob/2323f748c7a2bb7abe4591f92fd3db7f116ce785/app/src/main/java/com/okre/carrot/HomeFragment.kt#L48)

- 어댑터 클래스 생성과 동시에 데이터 받는 경우
```
var vo = mutableListOf<VO>()
val RVAdapter = RVAdapter(vo)
RV.adapter = RVAdapter
```
momoNote01에서 [어댑터 연결](https://github.com/okrecords/AppEightMusicList/blob/890b116e28a646176d75e5c569e54c9c0629d886/app/src/main/java/com/okre/appeightmusiclist/FirstFragment.kt#L37)

LayoutManager xml에서 지정하지 않았다면 반드시 추가해야 한다.
- LinearLayoutManager
```
layoutManager = LinearLayoutManager(context)
```
- GridLayoutManager
```
layoutManager = GridLayoutManager(view.context, 2 /* 열 갯수 */)
```
