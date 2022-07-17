// SPDX-License-Identifier: MIT

pragma solidity >= 0.7.0 < 0.9.0;


contract Voting{
    // constructor to initialize candiates
    // vote for candidates
    // get count of votes for each candidates
    bytes32[] public candidatesList;
    // 한번만 실행된다. 그후 수정 x
    mapping(bytes32 => uint8) public votesReceived;
    constructor(bytes32[] memory candidatesNames)  {
        candidatesList = candidatesNames;
    }

    function voteForCandidate(bytes32 candidate) public {
        require(validCandidate(candidate));
        votesReceived[candidate] += 1;
    }

    function totalVotesFor(bytes32 candidate) view public returns(uint8){
        require(validCandidate(candidate));
        return votesReceived[candidate];
    }

    function validCandidate(bytes32 candidate) view public returns(bool){
        for(uint i = 0; i<candidatesList.length;i++){
            if(candidatesList[i]==candidate){
                return true;
            }
        }
        return false;
    }

}