const person = {
    name: 'TeddyBear',
    address: {
        line1: 'Baker Street',
        city: 'London',
        country: 'UK',
    },
}

export default function LearningJavaScript() {
    return (
        <>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
        </>
    )
}