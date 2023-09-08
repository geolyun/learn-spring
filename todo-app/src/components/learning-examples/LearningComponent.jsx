import FirstComponent from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() {
    return (
      <div className="App">
        My Todo Application
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent>
        <ThirdComponent />
        <FourthComponent />
        <LearningJavaScript />
      </div>
    );
}