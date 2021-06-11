/**
  * Copyright 2021 json.cn 
  */
package com.beordie.bean;

/**
 * Auto-generated: 2021-05-27 20:32:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Link {

    private String content;
    private int count;
    private String description;
    private int icon;
    private int id;
    private int sort;
    private String title;
    private int typeId;

    @Override
    public String toString() {
        return "Link{" +
                "content='" + content + '\'' +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", icon=" + icon +
                ", id=" + id +
                ", sort=" + sort +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public Link(String content) {
        this.content = content;
    }

    public Link(String content, int count, String description, int icon, int id, int sort, String title, int typeId) {
        this.content = content;
        this.count = count;
        this.description = description;
        this.icon = icon;
        this.id = id;
        this.sort = sort;
        this.title = title;
        this.typeId = typeId;
    }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setCount(int count) {
         this.count = count;
     }
     public int getCount() {
         return count;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setIcon(int icon) {
         this.icon = icon;
     }
     public int getIcon() {
         return icon;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setSort(int sort) {
         this.sort = sort;
     }
     public int getSort() {
         return sort;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setTypeId(int typeId) {
         this.typeId = typeId;
     }
     public int getTypeId() {
         return typeId;
     }

}