# This is a bonus question. Feel free to skip to the next challenge.
#
# HackerRank is written in Ruby on Rails (RoR) and we have various classes
# defined in it. Some of them are:
#
#   1.- 'Hacker'
#   2.- 'Submission'
#   3.- 'TestCase'
#   4.- 'Contest'
#   5.- etc.
#
# You have been given a function where an object which may or may not be of the
# above mentioned type is sent as an argument.
#
# You have to use the 'case' control structure in Ruby to identify the class to
# which the object belongs and print the following output:
#
#   * If 'Hacker', output "It's a Hacker!"
#
#   * If 'Submission', output "It's a Submission!"
#
#   * If 'TestCase', output "It's a TestCase!"
#
#   * If 'Contest', output "It's a Contest!"
#
#   * For any other object, output "It's an unknown model"
#
# Note
#
# * Use 'case' (switch statement of Ruby).
# * Use 'puts' for printing.
# * Ruby Docs on 'case':
#     http://ruby-doc.org/docs/keywords/1.9/Object.html#method-i-case.

def identify_class(obj)
  case obj
  when Hacker, Submission, TestCase, Contest
    puts "It's a #{obj.class}!"
  else
    puts "It's an unknown model"
  end
end
