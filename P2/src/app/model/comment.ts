export class Comment{
    
    private comment_id:number;
    private comment_header: string;
    private comment: string;

    constructor(comment_id:number, comment_header:string, comment:string){
        this.comment_id = comment_id;
        this.comment_header = comment_header;
        this.comment = comment;
    }
    setId(id:number){
        this.comment_id = id;
    }

    setHead(head:string){
        this.comment_header = head;
    }

    setComment(comment:string){
        this.comment = comment;
    }

    getId():number{
        return this.comment_id;
    }

    getHead():string{
        return this.comment_header;
    }

    getComment():string{
        return this.comment;
    }

}