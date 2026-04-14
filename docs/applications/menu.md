# The Menu Class

Menu is the base class for all GWC-84 java menus, including applications.
All custom applications should inherit from the menu or one of the other base menus.

## Importing the Menu Class

In order to inherit from Menu, it needs to be imported from Menus.Menu

```
import Menus.Menu;
```

## Creating a custom menu using Menu

### Constructor

The constructor for a new menu must have parameters for Data (GWC_84_Java.Data), named storage,
and a String Stack, named events.

The storage argument should be assigned as the value for data (protected member of Menu),
and the events argument should be passed to Menu method setGlobalEvents 

#### Menu Type

There are three menu types:

- info: displays a page of information
- action: allows the user to perform actions
- return: passes information to another menu


NOTE: "return" is used mainly for menus where the user selects an option, although those could be "action" menus.

Select the type that best describes your menu and pass it to Menu's setMenuType method


#### Example Constructor

```
public NewMenu (Data storage, Stack<String> events)
{
    setMenuType("action");
    
    data = storage;
    setGlobalEvents(events);
}
```