import { QuizQuestion } from "./QuizQuestion";

export class Quiz{
    idQuiz:number;
    titre:string;
    postDateTime:Date;
    marks:number;
    poster:boolean;
    tauxSuccee:number;
    pourcentageNoteMoyenne:number;
    questions: QuizQuestion[];
}