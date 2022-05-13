import { QuizAnswer } from "./QuizAnswer";

export class QuizQuestion{
    idQuizQuestion:number;
    question:string;
    answers:QuizAnswer[];
    choice:any;
}