import React, { useState } from 'react'

const AddSearchQuery = () => {

    const [song, setSong] = useState({
        id:"",
        songName:"",
        artistName:"",
        albumName:"",
    })

  return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                 <h1>Add New Song</h1>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Song Name</label>
                <input 
                    type="text" 
                    name='songName'
                    value={song.songName} 
                    className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Artist Name</label>
                <input 
                    type="text" 
                    name='artistName'
                    value={song.artistName} 
                    className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Album Name</label>
                <input 
                    type="text" 
                    name='albumName' 
                    value={song.albumName}
                    className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='item-center justify-center h-14 w-full space-x-4 pt-4'>
                <button className='rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6'>Save</button>
                <button className='rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6'>Clear</button>
            </div>
        </div>
    </div>
  )
}

export default AddSearchQuery