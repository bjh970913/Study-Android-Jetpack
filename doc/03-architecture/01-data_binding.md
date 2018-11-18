# Data Binding


## Setup build env

```groovy
android {
    dataBinding {
        enabled = true
    }
}
```

## Layout

Root -> Layout Tag
Data Tag -> Declare variables used inside of view tag
View Root -> Root view element

`<variable>` declares variable's name and type.

Use `@{}` syntax to bind variable to view.

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"/>
   </LinearLayout>
</layout>
```

## DTO, VO

POJO Object. Can be used as variable's type.

Usually Data object is immutable VO. 


- VO as Java
  ```java
  class User {
    private String firstName;
    private String lastName;
    
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
    }
    public String getFirstName() {
        return this.firstName; 
    }
    public String getLastName() { 
        return this.lastName; 
    }
  }
  ```

- VO as Kotlin
  ```kotlin
  class User(
    val firstName: String,
    val lastName: String
  )
  ```

## Binding

Data binding create binding class related to layout.

Using `DataBindingUtil.setContentView` immediately inflate View Components and set content view.

Using bind classes `inflate` method, it will inflate view components, but user should manually set content view.

```kotlin
val binding: LayoutUserBinding = DataBindingUtil.setContentView(this, R.layout.layout_user)
```

```kotlin
val binding = LayoutUserBinding.inflate(layoutInflater)
setContentView(binding.root)
```

## Handle event

Two ways to bind view event to be handled.

- Method reference
  
  If method follows listener method's signature, data bing will will set listener to component. 
  
- Bind Listener

  Uses lambda expression

Method Listener is more like legacy set event listener.

Listener should follow exact signature of event call back.

Mean while, Bind Listener enables customize handler method's signature.

But on both method, user should manually set Handler to data binding object.

## Import

Inside data tag, import element could be used.

It can has alias.

```xml
<data>
    <import type="android.view.View"/>
    <import type="com.example.real.estate.View"
            alias="Vista"/>
</data>
```

## Variable

There is no limit for variables n data element.

## Custom Data Binding Class Name

Basically data binding class generated based on layout file name.

User can customize generated binding class name

- Customize binding class in <app>.databinding
  ```xml
  <data class="ContactItem">
  </data>
  ```
- ???
  ```xml
  <data class="ContactItem">
  </data>
  ```
- Customize binding class. Available in global scope
  ```xml
  <data class="com.example.ContactItem">
  </data>
  ```
## Include, Bind Expression

??

## Data Object

Change POJO object binds to binding does not reflect change to view.

Using Observable object, field, collection can notify object's property change to binding.

### Observable Object



### Observable Field
### Observable Collection